package hello.school;

import java.util.List;
import hello.school.Page;
public class BasicPage {
	
	private List<? extends Object> elements;
	private Page page;
	
	public BasicPage() {
		super();
	}

	public List<? extends Object> getElements() {
		return elements;
	}

	public void setElements(List<? extends Object> elements) {
		this.elements = elements;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
