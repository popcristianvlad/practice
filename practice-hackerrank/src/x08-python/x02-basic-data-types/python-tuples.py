if __name__ == '__main__':
    n = int(input())
    line = input()
    splitted_line = line.split(' ')
    my_tuple = tuple(int(i) for i in splitted_line)
    print(hash(my_tuple))
