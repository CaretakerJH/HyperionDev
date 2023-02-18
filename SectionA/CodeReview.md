CODE REVIEW

Firstly, I want to say that the code is functional. There are minor mistakes and improvements to be made in some areas which are outlined below:

Correctness: 
Line 1: The class appears to be unnecessary as it only has one function and groupAnagrams could be used directly however, if the class were to be expanded upon and more functions added, this would be the correct way to do so. 
Line 5: The sorted() method should sort the characters in the string i, so it should be 'x = "".join(sorted(i))
Otherwise, the code that groups together the anagram into sublists and sorts them is functional and correct which is great. Well done!

Styling:
The styling could definitely use more care, improvements can be made as follows:

Line 1: The class name could definitely be more descriptive, Solution is too vague and doesn't depict anything. A class name that could be used here is for example, "Anagram". 

Line 2: "groupAnagrams" is a good name for the function as it describes what it does. However, the notation could be improved upon according to python convention. Function names should be all lowercase with words separated by an underscore, thus: "group_anagrams". This improves your codes readability.

Line 5: The variable of 'x' is non-descriptive. It would be better to use a more meaningful name, such as anagram_key, also following the naming convention of variables in python.
And finally in this section, The indentation of the groupAnagrams method is incorrect. The result list and the for loop should be indented under the method definition. (Line 3-9)

Documentation:
The code is missing a docstring that describes what the groupAnagrams method does, what input it expects, and what output it returns.
An example of this docstring could be: 

    """Groups anagrams in a list of strings.

        Args:
        - strs: A list of strings.

        Returns:
        - A list of lists, where each inner list contains all anagrams from the input list."""

Efficiency:
I would say that the code is reasonably efficient, thinking about it, due to the fact that it utilizes the sort method on each string. The two factors that would influence efficiency would be the number of strings in the input and the length of the longest string. Thus the bottleneck of the computational power would be the utilisation of the sorted() method. This way is a good way of tackling the problem with a solution. 
Ways to improve the efficiency would be perhaps using a hashTable to map the strings to as it uses keys and links values to them. If you have not heard of a hashTable I would be glad to explain you through how they work so please just let me know. This would greatly improve efficiency as all anagrams when sorted are the same word. 

Overall, I would say this is a good solution as it is concise and completes the task. The steps I have indicated in the review would turn it into a great solution. Keep up the good work!



