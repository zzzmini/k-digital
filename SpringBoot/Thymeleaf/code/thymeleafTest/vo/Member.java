package com.example.thymeleafTest.vo;

import java.time.LocalDateTime;

public class Member {
    private int id;
    private String name;
    private String addr;
    private LocalDateTime created_at;

    public Member(int id, String name, String addr, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.created_at = created_at;
    }
    public static Member of(int id, String name, String addr, LocalDateTime created_at) {
        return new Member(id, name, addr, created_at);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
