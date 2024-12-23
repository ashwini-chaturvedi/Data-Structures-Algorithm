# Without Comments
```java
 public int minOperationsToSort(List<Integer>list){

        List<Integer>sortedList=new ArrayList<>(list);
        Collections.sort(sortedList);

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }
        
        int swaps=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(sortedList.get(i))) continue;

            int correctIdx=map.get(sortedList.get(i));
            
            map.put(list.get(i),correctIdx);//Change the Indexes.
            map.put(list.get(correctIdx),i);

           
            int temp=list.get(i);
            list.set(i,list.get(correctIdx));
            list.set(correctIdx,temp);

            swaps++;
        }
        return swaps;
    }
```
# With Comments
```java
 public int minOperationsToSort(List<Integer>list){

        List<Integer>sortedList=new ArrayList<>(list);//Make a Clone of the Original List
        Collections.sort(sortedList);//Sort that list to have the correct index on which that element has to be present
        //then we will compare the sorted list with the actual list

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){//Store the Element of actual list with there index
            map.put(list.get(i),i);
        }
        
        int swaps=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(sortedList.get(i))) continue;//if elements are equal means the element is at correct place in actual list where it should be after sorting so no need to disturb it.

            int correctIdx=map.get(sortedList.get(i));//Find the correct index for the Current Element in the Original List.

            //Swap the Indexes of the Elements in the map so that current Element has value of its correct Index where it should be.
            map.put(list.get(i),correctIdx);//Change the Indexes.
            map.put(list.get(correctIdx),i);

            //Swap the Elements at i and Correct Index so that the Element at i can go to its correct point and correct Element to be put at i in Original List.
            int temp=list.get(i);
            list.set(i,list.get(correctIdx));
            list.set(correctIdx,temp);

            swaps++;//Swap is do so Increase the Swaps.
        }
        return swaps;
    }
```
