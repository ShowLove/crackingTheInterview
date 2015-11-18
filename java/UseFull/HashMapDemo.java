/*
There are several differences between HashMap and Hashtable in Java:
1. Hashtable is synchronized, whereas HashMap is not. This makes HashMap better for 
non-threaded applications, as unsynchronized Objects typically perform better than 
synchronized ones.

2. Hashtable does not allow null keys or values.  HashMap allows one null key and any 
number of NULL values.

3. One of HashMap's subclasses is LinkedHashMap, so in the event that you'd want predictable 
iteration order (which is insertion order by default), you could easily swap out the HashMap 
for a LinkedHashMap. This wouldn't be as easy if you were using Hashtable.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

   public static void main(String args[]) {

      /* This is how to declare HashMap */
      HashMap<Integer, String> hmap = new HashMap<Integer, String>();

      /*Adding elements to HashMap*/
      hmap.put(12, "Chaitanya");
      hmap.put(2, "Rahul");
      hmap.put(7, "Singh");
      hmap.put(49, "Ajeet");
      hmap.put(3, "Anuj");

      /* Display content using Iterator*/
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
      }

      /* Get values based on key*/
      String var= hmap.get(2);
      System.out.println("Value at index 2 is: "+var);

      /* Remove values based on key*/
      hmap.remove(3);
      System.out.println("Map key and values after removal:");
      Set set2 = hmap.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
          Map.Entry mentry2 = (Map.Entry)iterator2.next();
          System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
          System.out.println(mentry2.getValue());
       }

   }
}

/*
Value at index 2 is: Rahul
Map key and values after removal:
Key is: 49 & Value is: Ajeet
Key is: 2 & Value is: Rahul
Key is: 7 & Value is: Singh
Key is: 12 & Value is: Chaitanya
*/