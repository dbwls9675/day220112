package Chapter09_ex06;

import static Chapter09_ex06.R.dao;
import static Chapter09_ex06.R.txtFld2;

import java.util.Vector;

public class SaramDao {
	// 일관성 때문에 이곳에 넣어둠.
	public static Vector<SaramDto> saramList = new Vector<SaramDto>();
	static {
		saramList.add(new SaramDto(1, "kim", "kim@aa.com", "010-1111-1111"));
		saramList.add(new SaramDto(2, "lee", "lee@aa.com", "010-2222-2222"));
		saramList.add(new SaramDto(3, "park", "park@aa.com", "010-3333-3333"));
	}
	public static int sequence = 4;

	public Vector selectAll() {
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			vector.add(saramList.get(i).toVector());
		}
		return vector;
	}

	public void insert(SaramDto saramDto) {
		if (saramDto != null) {
			saramDto.setIdx(sequence++);
			saramList.add(saramDto);
		}
	}

	public Vector search(SaramDto saramDto) {
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			if (saramDto.getName().equals(saramList.get(i).getName())) {
				vector = saramList.get(i).toVector();
				return vector;
			}
		}
		return null;
	}

	public Vector delete(SaramDto saramDto) {
		Vector vector = new Vector();
		for (int i = 0; i < saramList.size(); i++) {
			if (saramDto.getName().equals(saramList.get(i).getName())) {
				vector = saramList.get(i).toVector();
				return vector;
			}
		}
		return null;

	}
	
	public Vector modyfi(SaramDto saramDto) {
		return null;
	}

}
