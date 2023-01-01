package com.genealogy;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    record NewMemberRequest(String courtesy, Integer generation, String name, Integer parentId){}

    @PostMapping
    public void addMember(@RequestBody NewMemberRequest request) {
        Member member = new Member();
        member.setCourtesy(request.courtesy);
        member.setGeneration(request.generation);
        member.setName(request.name);
        member.setParentId(request.parentId);
        memberRepository.save(member);
    }
}
