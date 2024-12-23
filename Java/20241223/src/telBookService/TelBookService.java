package telBookService;

import dto.TelBookDto;
import repository.MapRepository;
import repository.TelBookRepository;
import telBookInterface.CrudInterface;

import java.util.List;

public class TelBookService {
    //    CrudInterface repository = new TelBookRepository();
    CrudInterface repository = new MapRepository();

    public int input(TelBookDto telBookDto) {
        return repository.insert(telBookDto);
    }

    public List<TelBookDto> getAllList() {
        return repository.getListAll();
    }

    public int deleteId(int deleteId) {
        return repository.delete(deleteId);
    }

    public TelBookDto findById(int updateId) {
        return repository.findById(updateId);
    }

    public int update(TelBookDto dto) {
        return repository.update(dto);
    }

    public List<TelBookDto> searchName(String searchName) {
        return repository.searchName(searchName);
    }
}
