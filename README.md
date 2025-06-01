## Ejercicio Java Spring con Base de Datos Postgres

1 - Crie uma classe chamada Produto com os seguintes atributos: id (Long, chave primária) nome (String) preco (Double) Anote a classe com @Entity e mapeie o atributo id como chave primária com @Id. A classe deve ter um construtor e os getters.

2 - Modifique o exercício anterior para usar a anotação @GeneratedValue no campo id, com a estratégia de geração automática de identificadores (GenerationType.IDENTITY).

3 - Agora, iremos usar vários parâmetros da anotação @Column. Acrescente os seguintes requisitos à classe Produto: O atributo nome deve ser único e não nulo. O atributo preco deve ser armazenado em uma coluna chamada valor.

4 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String) A classe deve ter um construtor e os getters. Transforme a classe em entidade.

5 - Crie uma classe Pedido com os seguintes atributos: id (Long, chave primária) data (LocalDate) A classe deve ter um construtor e os getters. Transforme a classe em entidade.

6 - Execute a aplicação e veja se todas as tabelas foram criadas corretamente. Quando estiver tudo certo, podemos ir para o próximo passo.

7 - Agora, iremos querer salvar dados no banco. Por isso, você deve criar vários repositórios diferentes: um para Pedido, outro para Produto e outro para Categoria.

8 - Para finalizar, crie um objeto de cada classe e use os repositórios para salvar os dados. Tudo certo para executar os dados? Provavelmente faltará um passo bem importante. Tente se lembrar do que acontece na aula e fazer este último passo. Você também pode analisar o log de erro :) Caso ainda precise de ajuda, na “Opinião do instrutor” terá uma dica para te ajudar.

Extra (pra quem quer mergulhar mesmo): uma vez que seu programa tiver executado corretamente, você pode testar os vários tipos de GenerationType do id. Adicione vários registros diferentes, comparando como o id é inserido no banco de dados. Na prática, qual a diferença de cada um dos tipos de geração de id?

Faça a mesma coisa para os vários parâmetros de @Column. Como os parâmetros alteram as colunas? Para te ajudar nessa segunda parte, você pode usar alguma ferramenta de IA, pedindo sugestões de casos para testar. Depois, conte para a gente no fórum sobre sua experiência :)

## EJERCICIOS FORTALECIENDO CONOCIMIENTOS

1 - Relacione Categoria e Produto usando @OneToMany, permitindo que uma categoria tenha vários produtos. Assim, estamos definindo um relacionamento 1:n do lado da categoria. Aqui, ao salvarmos uma categoria, queremos salvar seus produtos automaticamente também. Faça a configuração necessária para atender a esse requisito.

2 - Repare que o relacionamento criado é unidirecional: somente a classe Categoria o enxerga. Podemos deixá-lo bidirecional, configurando um relacionamento do tipo n:1 do lado do Produto, com a anotação @ManyToOne.

3 - Na sua classe Principal, você pode criar várias categorias e produtos diferentes e fazer as associações correspondentes. Extra (pra quem quer mergulhar mesmo): Agora, iremos trabalhar com um novo tipo de relacionamento: o relacionamento muitos para muitos, que usa a anotação @ManyToMany.

Para esse relacionamento, geralmente é criada uma tabela intermediária entre as entidades. Pesquise como isso é feito e mapeie um relacionamento do tipo @ManyToMany entre Produto e Pedido, usando uma tabela intermediária. Dica: use a anotação @JoinTable, em conjunto com @JoinColumn.

Depois, associe produtos a pedidos na sua classe Principal.

4 - Crie uma nova classe Fornecedor, com os atributos id e nome. Transforme a classe em entidade.

5 - Configure um relacionamento unidirecional entre Fornecedor e Produto. O relacionamento deve ser mapeado na classe Produto. Logo, é nessa classe que deverá ter a anotação de relacionamento. Qual é a melhor anotação para usarmos neste caso?

6 - Faça as devidas associações entre Fornecedor e Produto na sua classe Principal.

## EJERCICIO JPA

1 - Retorne todos os produtos com o nome exato fornecido.

2 - Retorne todos os produtos associados a uma categoria específica.

3 - Retorne produtos com preço maior que o valor fornecido.

4 - Retorne produtos com preço menor que o valor fornecido.

5 - Retorne produtos cujo nome contenha o termo especificado.

6 - Retorne pedidos que ainda não possuem uma data de entrega.

7 - Retorne pedidos com data de entrega preenchida.

8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.

9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.

10 - Retorne a contagem de produtos em uma categoria específica.

11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.

12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.

13 - Retorne pedidos feitos após uma data específica.

14 - Retorne pedidos feitos antes de uma data específica. , 15 - Retorne pedidos feitos em um intervalo de datas.

16 - Retorne os três produtos mais caros.

17 - Retorne os cinco produtos mais baratos de uma categoria.
