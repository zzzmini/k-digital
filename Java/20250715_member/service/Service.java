package service;

import vo.Member;

import java.util.Map;

//Create  :  addStore(Member)  put(key, Member) ---> key는 자동증가 -- void
//Read    :  findById(id)  get(key)     --  Member
//ReadAll :  findAll()     for ----          Map
//Update :  updateStore(id, Member)  put(key, Member) ---- boolean
//Delete  :  removeStore(id) remove(key)           ---- boolean
public interface Service {
    void addStore(Member member);  // 추가

    Member findById(int id);  // 1개 데이터 검색

    Map<Integer, Member> findAll();

    boolean updateStore(int id, Member member);

    boolean removeStore(int id);
}
