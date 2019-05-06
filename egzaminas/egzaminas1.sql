SELECT count(*) FROM egzaminas.studentai;

select * from egzaminas.studentai
where kursas=1
order by 'metai_metai' desc;

select * from egzaminas.studentai
where gimimo_metai<1991;

select kursas,count(kursas) as studentu_skaicius
from studentai
group by kursas
order by studentu_skaicius desc limit 2;

SELECT studijuojama_kalba, COUNT(studijuojama_kalba) AS mokosi_daugiausiai_studentu
FROM studentai
GROUP BY studijuojama_kalba
ORDER BY mokosi_daugiausiai_studentu DESC limit 1;