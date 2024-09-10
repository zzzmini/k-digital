package idol_project.service;

import idol_project.IdolMain;
import idol_project.vo.Idol;

public class IdolService implements IdolInterface {

	@Override
	public void insert(int insertKey, Idol idol) {
		System.out.println("insert 구현 서비스");
//		System.out.println("key = " + insertKey + ", idol = " + idol);
		IdolMain.strore.put(insertKey, idol);
	}

	@Override
	public void update(int updateKey, Idol idol) {
		System.out.println("update 구현 서비스");
	}

	@Override
	public void delete(int deleteKey) {
		System.out.println("delete 구현 서비스");
	}

	@Override
	public void selectAll() {
		System.out.println("전체검색 구현 서비스");
		if (IdolMain.strore.size() == 0) {
			System.out.println("저장된 자료가 없습니다.");
		} else {
			for (Integer key : IdolMain.strore.keySet()) {
				System.out.println("key = " + key + ", value = " //
						+ IdolMain.strore.get(key));
			}
		}
	}

}
