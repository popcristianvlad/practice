if __name__ == '__main__':
    N = int(input())

    result = []
    
    for _ in range (N):
        command = input()
        command = command.split(' ')
  
        if command[0] == 'insert':
            result.insert(int(command[1]), int(command[2]))
        if command[0] == 'print':
            print(result)
        if command[0] == 'remove':
            result.remove(int(command[1]))
        if command[0] == 'append':
            result.append(int(command[1]))
        if command[0] == 'sort':
            result.sort()
        if command[0] == 'pop':
            result.pop()
        if command[0] == 'reverse':
            result.reverse()
