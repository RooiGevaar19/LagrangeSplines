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

	public int getCount() {
		return entries.size();
	}

	public EntryManager getEntriesSubset(int begin, int end) {
		List<Entry> a = new ArrayList<Entry>();
		for (int i = begin; i < end; i++) a.add(entries.get(i));
		EntryManager b = new EntryManager(this.label, a);
		return b;
	}
}
