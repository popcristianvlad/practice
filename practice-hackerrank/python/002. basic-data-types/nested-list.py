if __name__ == '__main__':
    records = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        records.append([name, score])
    
    set_of_grades = set([float(item[1]) for item in records])
    set_of_grades_sorted = sorted(set_of_grades)
    second_lowest = set_of_grades_sorted[1]

    students = []
    for rec in records:
        if rec[1] == second_lowest:
            students.append(rec[0])
    
    students.sort()
        
    for stud in students:
        print(stud)