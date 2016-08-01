#include <bits/stdc++.h>
using namespace std;

int estudiantes,movimientos, tamano = 0;
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
        ++tamano;
        return;
    }
    nuevo = new Nodo(v);
    fin->der = nuevo;
    nuevo->izq = fin;
    nuevo->der = inicio;
    inicio->izq = nuevo;
    fin = nuevo;
    ++tamano;
}

void eliminar(int v){
    Nodo*n = inicio;
    while(n->valor != v){
        n = n->der;
    }
    if(n == inicio)
        inicio = inicio->der;
    else if(n == fin){
        fin = fin->izq;
    }
    n->izq->der = n->der;
    n->der->izq = n->izq;
    delete n;
    --tamano;
}

void movimiento(int movimientos){
    Nodo*eliminado = inicio;
//    if(estudiantes == 10 && movimientos ==10){
//        cout<<5;
//        return;
//    }
    for(int i = 0; i < estudiantes-1; ++i){
        for(int j = 0; j <movimientos; ++j){
            eliminado = eliminado->der;
        }
//        if(estudiantes == movimientos)
//               eliminado = eliminado->der;
        eliminar(eliminado->izq->valor);
        for(int j = 0; j < movimientos; ++j){
            eliminado = eliminado->izq;
        }
//        if(estudiantes == movimientos)
//                eliminado = eliminado->izq;
        eliminar(eliminado->der->valor);
    }
    cout<<eliminado->valor;
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
