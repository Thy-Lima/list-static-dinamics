package projeto.estruturas;

import projeto.interfaces.ListaTAD;

/**
 * @param <T>
 * @author guinh
 */
public class Lista<T> implements ListaTAD<T> {
    private T[] elementos;
    private int tamanhoAtual;
    
    public Lista(int cap){
        this.elementos = (T[]) new Object[cap];
        this.tamanhoAtual = 0;
    }
    
    public Lista(){
        this.elementos = (T[]) new Object[10];
        this.tamanhoAtual = 0;
    }

    @Override
    public int tamanho(){
        return this.tamanhoAtual;
    }
    
    @Override
    public boolean estaVazia(){
        return this.tamanho() == 0;
    }
    
    @Override
    public boolean estaCheia(){
        return this.tamanho() == this.elementos.length;
    }
    
    @Override
    public void adicionar(T item){
        if(this.estruturaNula() || this.estaCheia()){
            return;
        }
        else{
            this.elementos[this.tamanho()] = item;
            this.tamanhoAtual++;
        }
        
    }
    
    @Override
    public boolean adicionar(T item, int indice){
        if(this.estruturaNula() || this.indiceInvalido(indice) || this.itemNulo(item) || this.estaCheia()){
            return false;
        }
        else {
            for(int i=this.tamanho(); i>indice; i--){
                this.elementos[i] = this.elementos[i-1];
            }
            this.elementos[indice] = item;
            this.tamanhoAtual++;
        }
        
        return true;
    }
    
    @Override
    public void removerPrimeiro(){
        if(this.estruturaNula() || this.estaVazia()){
            return;
        }
        else{
            for(int i=0; i<this.tamanho()-1; i++){
                this.elementos[i] = this.elementos[i+1];
            }
            this.elementos[this.tamanho()-1] = null;
            this.tamanhoAtual--;
        }
    }
    
@Override
public T remover(){
    if(this.estruturaNula() || this.estaVazia()){
        return null;
    }
    else{
        T aux = this.elementos[0];
        for(int i=0; i<this.tamanho()-1; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[this.tamanho()-1] = null;
        this.tamanhoAtual--;
        return aux;
    }
}

@Override
public boolean remover(int indice){
    if(this.estruturaNula() || this.estaVazia() || this.indiceInvalido(indice)){
        return false;
    }
    else {
        for(int i=indice; i<this.tamanho()-1; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[this.tamanho()-1] = null;
        this.tamanhoAtual--;
    }
    
    return true;
}

@Override
public T buscar(int indice){
    if(this.estruturaNula() || this.estaVazia() || this.indiceInvalido(indice)){
        return null;
    }
    else{
        return this.elementos[indice];
    }
}

@Override
public int indice(T item){
    for(int i=0; i<this.tamanho(); i++){
            if(this.elementos[i].equals(item)){
                return i;
            }
        }
    return -1;
}

@Override
public boolean alterar(T item, int indice){
    if(this.estruturaNula() || this.estaVazia() || this.itemNulo(item) || this.indiceInvalido(indice)){
        return false;
    }
    else{
        this.elementos[indice] = item;
        return true;
    }
}

@Override
public String exibir(int indice){
    if(this.estruturaNula() || this.indiceInvalido(indice)){
        return ""; 
    }
    
    StringBuilder conteudo = new StringBuilder();
    conteudo.append("[");
    
    conteudo.append(this.elementos[indice].toString());
    
    conteudo.append("]");
    return conteudo.toString();
}

@Override
public String exibir(){
    StringBuilder conteudo = new StringBuilder();
    conteudo.append("[");
    
    for(int i=0; i<this.tamanho()-1; i++){
        conteudo.append(this.elementos[i].toString());
        conteudo.append(",");
    }
    
    if(this.tamanho()>0){
        conteudo.append(this.elementos[this.tamanho()-1].toString());
    }
    
    conteudo.append("]");
    return conteudo.toString();
}

@Override
public boolean limpar(){
    if(this.estruturaNula() || this.estaVazia()){
        return false;
    }
    else {
        while(this.remover() != null);
    }
    
    return true;
}

private boolean estruturaNula(){
        return this.elementos == null;
    }
    
    private boolean indiceInvalido(int indice){
        if(indice >= this.tamanho() || indice < 0){
            return true;
        }
        
        return false;
    }
    
    private boolean itemNulo(T item){
       boolean retorno = true;
        
       if(item != null){
           retorno = false;
       }
        
        return retorno;
    }
}
