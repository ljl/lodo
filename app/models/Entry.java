package models;

import java.util.List;

import siena.*;

public class Entry extends Model {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	public String content;
	public Entry parent;
	public boolean complete = false;
	
	public static Query<Entry> all() {
		return Model.all(Entry.class);
	}
	
	public static Entry getEntryById(Long id) {
		return all().filter("id", id).get();
	}
	
	public List<Entry> getChildren() {
		return all().filter("parent", this).fetch();
	}

}
