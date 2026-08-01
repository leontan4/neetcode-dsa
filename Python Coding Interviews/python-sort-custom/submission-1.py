from typing import List

def get_word_length(word: str) -> int:
    return len(word)

def sort_words(words: List[str]) -> List[str]:
    sorted_words = words.sort(key=get_word_length)
    return sorted_words


def sort_numbers(numbers: List[int]) -> List[int]:
    sorted_numbers = sorted(numbers)
    return sorted_numbers


# do not modify below this line
print(
    sort_words(["cherry", "apple", "blueberry", "banana", "watermelon", "zucchini", "kiwi", "pear"])
)

print(sort_numbers([1, -5, -3, 2, 4, 11, -19, 9, -2, 5, -6, 7, -4, 2, 6]))
