#include <bits/stdc++.h>
using namespace std;

int estudiantes,movimientos;
class Nodo{
public:
    Nodo*izq;
    Nodo*der;
    int valor;
    Nodo(int v){
        valor = v;
    }
}*inicio,*fin;

void insertar(int v){
    Nodo*nuevo;
    if(inicio == NULL){
        nuevo = new Nodo(v);
        nuevo->der = nuevo;
        nuevo->izq = nuevo;
        fin = nuevo;
        inicio = nuevo;
        return;
    }
    nuevo = new Nodo(v);
    fin->der = nuevo;
    nuevo->izq = fin;
    nuevo->der = inicio;
    inicio->izq = nuevo;
    fin = nuevo;
}

void eliminar(Nodo*n){
    if(n == inicio)
        inicio = inicio->der;
    else if(n == fin){
        fin = fin->izq;
    }
    n->izq->der = n->der;
    n->der->izq = n->izq;
    delete n;
}

void movimiento(int movimientos){
    Nodo*eliminado = inicio;
    while(inicio != fin){
        for(int j = 0; j < movimientos%estudiantes; ++j){
            eliminado = eliminado->der;
        }
        eliminar(eliminado->izq);
        --estudiantes;
        for(int j = 0; j < movimientos%estudiantes; ++j){
            eliminado = eliminado->izq;
        }
        eliminar(eliminado->der);
        --estudiantes;
    }
    cout<<eliminado->valor<<endl;
    eliminado = NULL;
    delete eliminado;
    inicio = NULL;
    fin = NULL;
    delete inicio;
    delete fin;
}

void recorrer(Nodo*n){
    while(n != fin){
        cout<<n->valor<<" ";
        n = n->der;
    }
    cout<<fin->valor;
}
int main(){
    while(cin){
        cin>>estudiantes>>movimientos;
        for(int i = 1; i <= estudiantes; ++i){
            insertar(i);
        }
        if(estudiantes ==0 && movimientos==0)
            break;
        movimiento(movimientos);
    }
    return 0;
}
