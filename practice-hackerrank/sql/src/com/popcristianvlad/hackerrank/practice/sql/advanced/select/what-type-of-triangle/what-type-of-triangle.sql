select
    case
        when A+B<=C or A+C<=B or C+B<=A then 'Not A Triangle'
        when A=B and B=C then 'Equilateral'
        when A=B or B=c or A=c then 'Isosceles'
        else 'Scalene'
        END
from Triangles;