package models;

import java.util.List;

import siena.*;

public class Entry extends Model {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	public String content;
	public Entry parent;
	@Filter("parent")
	public Query<Entry> children;
	
	
	public static Query<Entry> all() {
		return Model.all(Entry.class);
	}
	
	public static Entry getEntryById(Long id) {
		return all().filter("id", id).get();
	}

}
