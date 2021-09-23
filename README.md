# live-design-patterns-para-ddd
Versão em java da Imersão Fullcycle sobre o temo Design Patterns para DDD  apresentada pelo Rodrigo Branas no  workshop https://www.youtube.com/watch?v=aBZvS-1N_ys.

## Sobre o projeto

Como exemplo foi tratado do problema de operações financeiras envolvendo creditação, debito e transferência de saldo entre contas financeiras.
Para tratar as operações foi utiliado o design pattern Command no qual foi criado três comandos  um para Debito,Crédito e Transferência. Para realizar a escuta e aplicar os  comandos enviados foi utiliado o design pattern de observer, no qual para cada comando foi criado um observer para tratar as ações necessárias. E para a criação da entidade de conta foi aplicado o design pattern builder.
