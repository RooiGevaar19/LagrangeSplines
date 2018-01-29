import java.util.List;
import java.util.ArrayList;

public class EntryManager {
	private String label = "";
	private List<Entry> entries = new ArrayList<Entry>();

	public EntryManager() {

	}

	public EntryManager(String name) {
		this.label = name;
	}

	public EntryManager(String name, List<Entry> entriesSet) {
		this.label = name;
		this.entries = entriesSet;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String a) {
		this.label = a;
	}

	public List<Entry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entry> a) {
		this.entries = a;
	}
}