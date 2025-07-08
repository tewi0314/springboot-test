package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    private Map<Long, Member> memberMap = new HashMap<>();
    private Long sequence = 1L;

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        member.setId(sequence++);
        memberMap.put(member.getId(), member);
        return member;
    }

    @GetMapping
    public List<Member> findAll(){
        return new ArrayList<>(memberMap.values());
    }

    @GetMapping("/{id}")
    public Member findOne(@PathVariable Long id){
        return memberMap.get(id);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member newMember){
        Member member = memberMap.get(id);
        if(member != null){
            member.setName(newMember.getName());
            member.setAge(newMember.getAge());
        }
        return member;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        memberMap.remove(id);
        return "deleted";
    }
}
