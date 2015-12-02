XXROUTINE ; 
 ; comment
label(asfd) ;
 B 
 C foo 
 Q:'(1+2!3_4+5-6*7/8#9\10**11=12<13>14]15[16]]17&18!19+"20")
 F name=1:2 Q:0 
 K:name @name,name2,^aa,(a,b),p(3),^q(3,4),^$CHARACTER() 
 I 1,"false",@foo,(1+name),p(3) 
 D foo 
 G:1 foo:0,bar:(quack+1) 
 H:0 
 HANG 10 
 M:0 @bar,foo=^bar(12) 
 N foo
 S (foo,bar)=3,$X=2,$Y=3,$DEVICE=4,$KEY=5,$ECODE=6,$ETRAP=7,$P(foo,"^",3)="3",$E(bar,"^")=9 
 R foo,bar#2,*q 
 U foo 
 O foo 
 W:0 foo,*foo 
 X bob 
 L foo 
 J ^foo 
 Q foo
 ;
another(foo) ;
 Q 
 N R,Q,C,D,E,W,B,G,H,S,T,U,V,F,L,P,N,J,A 
 S N=$G(N),Q='N,F=Q+Q,P=F+F,W=$L($T(Q)) 
 S W=$E(W,Q),S='N_+N,W=W-F*S,L=$G(L),R=$C(Q_F_P),R(F)=$C(F+Q_F),R(P)=$C(W-F) 
 W # 
 S T=$E($T(Q+F),F,W\S)_$C(W+S+F) 
 X T 
 S B=$P(T,$C(P_P),F),C=B\(W*W),D=B-(C*W*W)\W
 F G=S-Q:F:S+F+Q S E=B-(C*W*W+(D*W)),H=$E($T(Q),G),@H=$S(@H<S:'Q,Q:N)_@H,T=C_D_E
 F A=Q:Q:W\S S J=$E(T,A),C(F)=$S(J>(F+Q)&(J<(S-F)):Q,Q:+N),C(P)=$S(J#F:Q,Q:+N) D
 .S C(Q)=$S(J<(S-F):+N,Q:Q),C(F+Q)=$S(J>Q&(J<(S-F))&(J'=(P+'L))&(J'=(P)):Q,Q:+N)
 ; .S H('L)=L F  S H(N?.E)=$O(C(H('$G(N)))) Q:H('+L)=L  S F(A,H('L))=C(H(W[(W\S)))
 ; F U=Q:Q:P W !,R F V=Q:Q:P+F W $S(F(V,U):'Q,Q:$C(P_(W\S))) W:'(V#F) $C('N_F_F+F)
 ; W !!,R(F)_C_R(P)_D_R(P)_E_R(F) 
 ; X $RE($E($T(Q),Q+F,P+Q))_R(P)_'N 
 ; W # 
 ; G:N=L 
 ; Q+F 
 ; Q
