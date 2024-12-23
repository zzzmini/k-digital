package repository;

import dto.InitData;
import dto.TelBookDto;
import telBookInterface.CrudInterface;

import java.util.ArrayList;
import java.util.List;

public class MapRepository implements CrudInterface {
    @Override
    public TelBookDto findById(int updateId) {
        return InitData.store.get(updateId);
    }

    @Override
    public List<TelBookDto> searchName(String searchName) {
        List<TelBookDto> list = new ArrayList<>();
        for (Integer key : InitData.store.keySet()) {
            if (InitData.store.get(key).getName().equals(searchName)) {
                list.add(InitData.store.get(key));
            }
        }
        return list;
    }

    @Override
    public int insert(TelBookDto telBook) {
        InitData.store.put(InitData.id, telBook);
        InitData.id++;
        return 1;
    }

    @Override
    public int update(TelBookDto telBook) {
        int updateKey = telBook.getId();
        InitData.store.put(updateKey, telBook);
        return 1;
    }

    @Override
    public int delete(Integer id) {
        InitData.store.remove(id);
        return 1;
    }

    @Override
    public List<TelBookDto> getListAll() {
        List<TelBookDto> list = new ArrayList<>();
        for (Integer key : InitData.store.keySet()) {
            list.add(InitData.store.get(key));
        }
        return list;
    }

    @Override
    public TelBookDto getOne(String name) {
        for (Integer key : InitData.store.keySet()) {
            if (InitData.store.get(key).getName().equals(name)) {
                return InitData.store.get(key);
            }
        }
        return null;
    }
}
