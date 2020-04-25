package projeto.interfaces;

/**
 *@param <T>
 *@author guinh
 */
public interface ListaTAD<T> {
    public int tamanho();
    public boolean estaVazia();
    public boolean estaCheia();
    public void adicionar(T item);
    public boolean adicionar(T item, int indice);
    public void removerPrimeiro();
    public T remover();
    public boolean remover(int indice);
    public T buscar(int indice);
    public int indice(T item);
    public boolean alterar(T item,int indice);
    public String exibir(int indice);
    public String exibir();
    public boolean limpar();
}
