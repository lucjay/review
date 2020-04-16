package review.emp;

public class EmpSearchDTO extends EmpDTO {

	String keyword;
	String searchWord;
	int first;
	int end;

	public String getKeyword() {
		return keyword;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public int getFirst() {
		return first;
	}

	public int getEnd() {
		return end;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
