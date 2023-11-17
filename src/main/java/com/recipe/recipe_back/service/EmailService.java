package com.recipe.recipe_back.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void mailSend(String email, String memberPassword) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("noreply@baeldung.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("임시 비밀번호 발급 이메일입니다.");
        mailMessage.setText("회원님의 발급된 임시비밀번호는 " + memberPassword +  "입니다." + "로그인 후에 비밀번호를 변경해 주세요.");

        javaMailSender.send(mailMessage);
    }
}
