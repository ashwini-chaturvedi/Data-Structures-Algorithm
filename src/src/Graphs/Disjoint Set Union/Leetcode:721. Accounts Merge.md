# Approach Behind the Solution: Accounts Merge Problem

The implemented solution uses the **Union-Find (Disjoint Set Union - DSU)** data structure to efficiently group and merge email accounts that belong to the same user.

---
## **Approach**

### **1. Union-Find Data Structure**
The DSU structure is used to group items (email accounts) into disjoint sets. Each email or account belongs to one unique group (or set), represented by a *parent index*. DSU helps:
- **Union:** Merging two sets when we detect shared ownership of an email.
- **Find:** Identifying the representative (parent) of a set to determine which group an email belongs to.

---

### **2. Steps in the Solution**

#### **Step 1: Initialize the Union-Find Data Structure**
- Each account initially starts as its own parent (self-parenting) because no accounts are merged at the beginning.
- Two arrays are used:
  - `Parents`: Tracks the parent of each account.
  - `Rank`: Helps optimize the union operation by attaching smaller trees to larger ones.

---

#### **Step 2: Map Emails to Their Parent Accounts**
- Use a `Map<String, Integer>` called `emailToParent`:
  - **Key:** Email ID
  - **Value:** The index of the account it belongs to.
- Traverse each account in the input list:
  - For each email:
    - If it’s not in the map, add it with the account’s index.
    - If it’s already in the map, perform a **Union** operation to merge the two accounts (the current account and the account already associated with the email).

**Union Explanation:**
- The `Union` function merges the sets of two accounts based on their parent indices. The `Rank` ensures that the smaller tree is attached under the larger tree to maintain a balanced DSU structure.

---

#### **Step 3: Group Emails by Their Ultimate Parent**
- Use a `Map<Integer, List<String>>` called `parentToEmail`:
  - **Key:** The representative parent index of a group.
  - **Value:** A list of emails that belong to this group.
- Traverse all the email mappings (`emailToParent`):
  - For each email, find its parent index using the `find` function.
  - Add the email to the corresponding parent’s list in `parentToEmail`.

**Find Explanation:**
- The `find` function recursively identifies the ultimate parent of a given account. It also performs *path compression* to optimize subsequent queries by directly linking all nodes in the path to the root parent.

---

#### **Step 4: Construct the Final Merged Accounts**
- Traverse the `parentToEmail` map:
  - For each group (identified by a parent index):
    - Sort the emails lexicographically.
    - Create a new list starting with the person’s name (`accounts.get(parentIndex).get(0)`).
    - Add all the sorted emails to this list.
    - Add this merged account to the final result.

---

## **Time Complexity**
1. **Union-Find Operations:**  
   - The `find` and `union` operations are nearly constant due to path compression and union by rank. Their amortized time complexity is \( O(\alpha(n)) \), where \( \alpha \) is the inverse Ackermann function (very small for practical input sizes).

2. **Iterating Over Accounts and Emails:**  
   - Let \( n \) be the number of accounts and \( m \) the total number of emails.
   - Iterating over all accounts and emails takes \( O(m) \).

3. **Sorting Emails in Each Group:**  
   - Sorting all email groups takes \( O(m \log m) \).

**Overall Time Complexity:**  
\[ O(m \alpha(n) + m \log m) \]

---

## **Space Complexity**
1. DSU arrays (`Parents` and `Rank`): \( O(n) \), where \( n \) is the number of accounts.
2. `emailToParent` map: \( O(m) \), where \( m \) is the total number of emails.
3. `parentToEmail` map: \( O(m) \).

**Overall Space Complexity:**  
\[ O(n + m) \]

---

## **Intuition Behind the Approach**
The core idea is to treat each account as a node and the shared emails as connections between nodes. By applying DSU, we can efficiently identify and merge connected components (i.e., accounts that share emails). This eliminates redundant accounts while preserving the associations between names and emails.

This approach is efficient, scalable, and works well for the problem constraints.

```java
class Solution {

    public int find(int x, int[] Parents) {
        if (x == Parents[x]) return x;

        return Parents[x] = find(Parents[x], Parents);
    }

    public void Union(int x, int y, int[] Parents, int[] Rank) {
        int ParentX = find(x, Parents);
        int ParentY = find(y, Parents);

        if (ParentX == ParentY) return;

        if (Rank[ParentX] > Rank[ParentY]) {
            Parents[ParentY] = ParentX;
        } else if (Rank[ParentX] < Rank[ParentY]) {
            Parents[ParentX] = ParentY;
        } else {
            Parents[ParentY] = ParentX;
            Rank[ParentX]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] Parents = new int[accounts.size()];
        int[] Rank = new int[accounts.size()]; // Initially all have Rank Zero

        // Initialize the Union-Find data structure
        for (int i = 0; i < accounts.size(); i++) {
            Parents[i] = i; // Parent of itself
        }

        //Use a Map to Bind the Email Id with index number of the Person whose email is it or at which index's list this email is present

        Map<String, Integer> emailToParent = new HashMap<>();

        // Build the Union-Find structure
        for (int i = 0; i < accounts.size(); i++) {
            // Skip the 0th element because it is the name of the person
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String emailId = accounts.get(i).get(j);//get the Email id
                if (!emailToParent.containsKey(emailId)) {//Put the Email Id
                    emailToParent.put(emailId, i);
                } else {
                    Union(i, emailToParent.get(emailId), Parents, Rank);//if that email is already present in the Map then just make a Union of the current index and the index Present in the Map this will Merge the users of the Email Id
                }
            }
        }

        // Group emails by their ultimate parent index
        Map<Integer, List<String>> parentToEmail = new HashMap<>();//Use a Map to map the parent Index with all the emails that are Merged using DSU
        for (Map.Entry<String, Integer> entry : emailToParent.entrySet()) {
            String emailId = entry.getKey();//Get the Email Id
            int parentIndex = find(entry.getValue(), Parents);//Parent of the current value because we have done Union of the Indexes so by this we can identify which is the Parent of current index means the emails of this person is Merged with which another Person.

            if (!parentToEmail.containsKey(parentIndex)) {
                parentToEmail.put(parentIndex, new ArrayList<>());
            }
            parentToEmail.get(parentIndex).add(emailId);
        }

        // Prepare the result By Extracting the Name and then Extracting all the Emails and Putting them all together
        List<List<String>> Merged = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : parentToEmail.entrySet()) {
            //Find the Emails and Sort them
            int index = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails); // Sort emails lexicographically

            // Add the name as the first element
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(index).get(0)); // Get the name
            mergedAccount.addAll(emails); // Add all the emails that are sorted

            Merged.add(mergedAccount);//Add this Person in the final result
        }

        return Merged;
    }
}

```
