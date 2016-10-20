package programa;

import javax.swing.JOptionPane;

public class ProgramaOtica {
	public static void main(String[] args) throws LENException, NULLException {
		// TODO Auto-generated method stub
		
		boolean run = true;
		//Fachada fachada = new Fachada(); implement
		EntradaDeDados dados = new EntradaDeDados();
		
		while (run) {
			int opcao;
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1. Cliente\n 2. Fornecedor\n 3. Produto\n 4. Venda\n 0. Encerrar Programa"));
			switch (opcao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Programa encerrado\n    BYE");
					run = false;
					break;
				case 1://Cliente
					int opcaoCliente;
					opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("    CLIENTE\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoCliente){
						case 0://voltar menu
							break;
						case 1://inserir
							Cliente tempC1 = new Cliente();
							try{
								tempC1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
								tempC1.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
								tempC1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
								tempC1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
								tempC1.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
								tempC1.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
								tempC1.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
								tempC1.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
								dados.clientes.inserirCliente(tempC1);
							} catch (LENException e) {
								JOptionPane.showMessageDialog(null, e);							}
							break;
						case 2://atualizar
							Cliente tempC2 = new Cliente();
							tempC2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							tempC2.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
							tempC2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							tempC2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							tempC2.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
							tempC2.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
							tempC2.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
							tempC2.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
							dados.clientes.atualizarCliente(tempC2);
							break;
						case 3://remover
							int deletaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							dados.clientes.removerCliente(deletaC);
							break;
						case 4://procurar
							Cliente tempC4 = new Cliente();
							int buscaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempC4 = dados.clientes.procurarCliente(buscaC);
							System.out.printf("nome: %s\nnascimento: %s\ncpf: %s\ntelefone: %s\ncep: %s\nestado: %s\ncidade: %s\nrua: %s\n", 
							tempC4.getNome(),tempC4.getNascimento(),tempC4.getCpf(),tempC4.getTelefone(),tempC4.getCep(),tempC4.getEstado(),tempC4.getCidade(),tempC4.getRua());
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 2://Fornecedor
					int opcaoFornecedor = Integer.parseInt(JOptionPane.showInputDialog("    FORNECEDOR\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoFornecedor){
						case 0://voltar menu
							break;
						case 1://inserir
							Fornecedor tempF1 = new Fornecedor();
							tempF1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							tempF1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							tempF1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							dados.fornecedores.inserirFornecedor(tempF1);
							break;
						case 2://atualizar
							Fornecedor tempF2 = new Fornecedor();
							tempF2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							tempF2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							tempF2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							dados.fornecedores.atualizarFornecedor(tempF2);
							break;
						case 3://remover
							int deletaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							dados.fornecedores.removerFornecedor(deletaF);
							break;
						case 4://procurar
							Fornecedor tempF4 = new Fornecedor();
							int buscaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempF4 = dados.fornecedores.procurarFornecedor(buscaF);
							System.out.printf("nome: %s\ncpf: %s\ntelefone: %s\n", 
									tempF4.getNome(),tempF4.getCpf(),tempF4.getTelefone());
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 3://Produto
					int opcaoProduto = Integer.parseInt(JOptionPane.showInputDialog("    PRODUTO\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoProduto){
						case 1://inserir
							Produto tempP1 = new Produto();
							tempP1.setNome(JOptionPane.showInputDialog("Qual o nome?"));
							tempP1.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
							tempP1.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
							tempP1.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
							tempP1.setFornecedor(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do fornecedor?")));
							//tempP1.fornecedor.setnome algo assim?  (sugiro id, se pegar kk)
							dados.produtos.inserirProduto(tempP1);
							break;
						case 2://atualizar
							Produto tempP2 = new Produto();
							tempP2.setNome(JOptionPane.showInputDialog("Qual o nome?"));
							tempP2.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
							tempP2.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
							tempP2.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
							tempP2.setFornecedor(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do fornecedor?")));
							// perae que vamo discutir como fazer esse fornecedor aqui (sugiro id, se pegar kk)
							dados.produtos.atualizarProduto(tempP2);
							break;
						case 3://remover
							int deletaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							dados.produtos.removerProduto(deletaP);
							break;
						case 4://procurar
							Produto tempP4 = new Produto();
							int buscaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempP4 = dados.produtos.procurarProduto(buscaP);
							System.out.printf("nome: %s\nmarca: %s\nvalor de compra: %f\nvalor de venda: %f\n", 
									tempP4.getNome(),tempP4.getMarca(),tempP4.getValorCompra(),tempP4.getValorVenda());
							//daqui a pouco vemos isso de fornecedor, kk (que daqui a pouco, olha a hora)
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 4://Venda
					int opcaoVenda = Integer.parseInt(JOptionPane.showInputDialog("    VENDA\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch(opcaoVenda){
						case 1://inserir
							Venda tempV1 = new Venda();
							tempV1.setCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
							tempV1.setProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto?")));
							dados.vendas.inserirVenda(tempV1);
							break;
						case 2://atualizar
							Venda tempV2 = new Venda();
							tempV2.setCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
							tempV2.setProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto?")));
							dados.vendas.atualizarVenda(tempV2);
							break;
						case 3://remover
							int deletaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							dados.vendas.removerVenda(deletaV);
							break;
						case 4://procurar
							Venda tempV4 = new Venda();
							int buscaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempV4 = dados.vendas.procurarVenda(buscaV);
							Cliente cliente = new Cliente();
							Produto produto = new Produto();
							cliente = tempV4.getCliente();
							produto = tempV4.getProduto();
							System.out.printf("nome Cliente: %s\nid: %d\n nome Produto: %s\n", 
									cliente.getNome(),tempV4.getId(),produto.getNome());
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
					break;
			}
		}
	}

}