package com.genealogy;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    record NewMemberRequest(String courtesy, Integer generation, String name, Integer parentId, String description){}

    @PostMapping
    public void addMember(@RequestBody NewMemberRequest request) {
        Member member = new Member();
        member.setCourtesy(request.courtesy);
        member.setGeneration(request.generation);
        member.setName(request.name);
        member.setParentId(request.parentId);
        member.setDescription(request.description);
        memberRepository.save(member);
    }

    @PutMapping("{memberId}")
    public void updateMember(@PathVariable("memberId") Integer id, @RequestBody NewMemberRequest request) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()) {
            member.get().setCourtesy(request.courtesy);
            member.get().setGeneration(request.generation);
            member.get().setName(request.name);
            member.get().setParentId(request.parentId);
            member.get().setDescription(request.description);
            memberRepository.save(member.get());
        }
    }

    @DeleteMapping("{memberId}")
    public void deleteMember(@PathVariable("memberId") Integer id) {
        memberRepository.deleteById(id);
    }
}
