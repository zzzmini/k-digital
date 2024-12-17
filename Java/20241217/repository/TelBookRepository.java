package repository;

import dto.InitData;
import dto.TelBookDto;
import telBookInterface.CrudInterface;

import java.util.ArrayList;
import java.util.List;

public class TelBookRepository implements CrudInterface {
    @Override
    public int insert(TelBookDto telBook) {
        InitData.dtoList.add(telBook);
        // 아이디를 강제 증가
        InitData.id++;
        // 성공 : 1, 실패 : 0
        return 1;
    }

    @Override
    public int update(TelBookDto telBook) {
        int index = InitData.dtoList.indexOf(telBook);
        InitData.dtoList.set(index, telBook);
        return 1;
    }

    @Override
    public int delete(Integer id) {
        for (TelBookDto x : InitData.dtoList) {
            if (x.getId() == id) {
                InitData.dtoList.remove(x);
                break;
            }
        }
        return 0;
    }

    @Override
    public List<TelBookDto> getListAll() {

        return InitData.dtoList;
    }

    @Override
    public TelBookDto getOne(String name) {
        for (TelBookDto x : InitData.dtoList) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        // 찾는 데이터없는 경우
        return null;
    }

    public TelBookDto findById(int updateId) {
        for (TelBookDto x : InitData.dtoList) {
            if (x.getId() == updateId) {
                return x;
            }
        }
        return null;
    }

    public List<TelBookDto> searchName(String searchName) {
        List<TelBookDto> list = new ArrayList<>();
        for (TelBookDto dto : InitData.dtoList) {
            if (dto.getName().equals(searchName)) {
                list.add(dto);
            }
        }
        return list;
    }
}
