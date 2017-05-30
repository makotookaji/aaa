package sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

public class EclipseCollectionSample {
	public static void main(String[] args) {

		MutableList<Map<String, Object>> mapList = Lists.mutable.empty();
		for (int i = 0; i < 1000; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("itemcode", "dfj;lajeflwa" + i);
			map.put("id", i);
			mapList.add(map);
		}

		Iterator<String> str = mapList.collect(map -> (String) map.get("itemcode")).iterator();
		while (str.hasNext()) {
			System.out.println("itemcode" + str.next());
		}

		mapList = mapList.select(map -> (Integer) map.get("id") % 3 == 0 || (Integer) map.get("id") % 5 == 0);
		Iterator<Map<String, Object>> iterator = mapList.iterator();
		while (iterator.hasNext()) {
			System.out.println("id:" + iterator.next().get("id"));
		}
	}
}
