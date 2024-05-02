# Solução do desafio : 

## 1 - Buscar o nome e ano dos filmes

```sql
SELECT Nome, Ano 
FROM Filmes
```


## 2 - Buscar o nome e ano dos filmes, ordenados por ordem crescente pelo ano

```sql
SELECT Nome, Ano 
FROM Filmes 
ORDER BY Ano
```

## 3 - Buscar pelo filme de volta para o futuro, trazendo o nome, ano e a duração

```sql
SELECT * FROM Filmes
WHERE Nome = 'De Volta para o Futuro'
```

## 4 - Buscar os filmes lançados em 1997

```sql
SELECT * FROM Filmes 
WHERE Ano = 1997
```

## 5 - Buscar os filmes lançados APÓS o ano 2000

```sql
SELECT * FROM Filmes 
WHERE Ano > 2000
```

## 6 - Buscar os filmes com a duracao maior que 100 e menor que 150, ordenando pela duracao em ordem crescente

```sql
SELECT * FROM Filmes
WHERE Duracao > 100 AND Duracao < 150
ORDER BY Duracao
```

## 7 - Buscar a quantidade de filmes lançadas no ano, agrupando por ano, ordenando pela duracao* em ordem decrescente

*: Por fazer a ordenação pela duração ficar estranho e tendo como base a imagem do resultado esperado, fiz a ordenação com base na quantidade de filmes por ano.

```sql
SELECT Ano, COUNT(*) Quantidade 
FROM Filmes
GROUP BY Ano 
ORDER BY Quantidade DESC
```

## 8 - Buscar os Atores do gênero masculino, retornando o PrimeiroNome, UltimoNome

```sql
SELECT PrimeiroNome, UltimoNome 
FROM Atores 
WHERE Genero = 'M'
```

## 9 - Buscar os Atores do gênero feminino, retornando o PrimeiroNome, UltimoNome, e ordenando pelo PrimeiroNome

```sql
SELECT PrimeiroNome, UltimoNome 
FROM Atores 
WHERE Genero = 'F'
ORDER BY PrimeiroNome
```

## 10 - Buscar o nome do filme e o gênero

```sql
SELECT f.Nome, g.Genero 
FROM Filmes f 
    JOIN FilmesGenero fg ON fg.IdFilme = f.Id
    JOIN Genero g ON fg.IdGenero = g.Id
```

## 11 - Buscar o nome do filme e o gênero do tipo "Mistério"

```sql
SELECT f.Nome, g.Genero 
FROM Filmes f 
    JOIN FilmesGenero fg ON fg.IdFilme = f.Id
    JOIN Genero g ON fg.IdGenero = g.Id
WHERE g.Genero = 'Mistério'
```

## 12 - Buscar o nome do filme e os atores, trazendo o PrimeiroNome, UltimoNome e seu Papel

```sql
SELECT f.Nome, a.PrimeiroNome, a.UltimoNome, e.Papel 
FROM Filmes f 
    JOIN ElencoFilme e ON e.IdFilme = f.Id
    JOIN Atores a ON e.IdAtor = a.Id
```