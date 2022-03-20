package melimelli.melmelipractice.controller;

import melimelli.melmelipractice.domain.Member;
import melimelli.melmelipractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController (MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "/members/createMember";
    }

    @PostMapping(value = "/members/new")
    public String create(Member member) {
        Member member1 = new Member();
        member.setName(member.getName());
        memberService.join(member);
        return "redirect:/"; }

    @GetMapping("/members")
    public String memberPage(Model model){
        List<Member> list = memberService.findMembers();
        model.addAttribute("list",list);
        return "/members/memberPage";
    }
}
