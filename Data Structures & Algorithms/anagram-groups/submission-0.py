class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        word_dict = {}

        for word in sorted(strs):
            word_dict[word] = ''.join(sorted(word))
        
        grouped_words = {}

        # Loop through the dictionary
        for word, sorted_letters in word_dict.items():
            # Use sorted letters as the key
            if sorted_letters not in grouped_words:
                grouped_words[sorted_letters] = []
            grouped_words[sorted_letters].append(word)

        # Output the grouped words as a list of lists
        output = list(grouped_words.values())
        return output
