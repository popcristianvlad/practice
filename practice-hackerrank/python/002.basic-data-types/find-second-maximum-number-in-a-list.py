if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    arr = list(arr)
    winner = max(arr[0], arr[1])
    runner_up = min(arr[0], arr[1])

    for i in range(2, n):
        if arr[i] > winner:
            runner_up = winner
            winner = arr[i]
        if runner_up < arr[i] < winner:
            runner_up = arr[i]
        if winner == runner_up:
            runner_up = arr[i]
    
    print(runner_up)