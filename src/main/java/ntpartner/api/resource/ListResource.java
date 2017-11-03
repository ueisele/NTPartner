package ntpartner.api.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class ListResource<T> extends ResourceSupport {
	private Collection<T> list;

	public Collection<T> getList() {
		return list;
	}
	
	public ListResource(Collection<T> list) {
		this.list = list;
	}

}
