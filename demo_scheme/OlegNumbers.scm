
(define one '(1))
(define zero '())

;;; There are 23 relations
; full_addero 260

(define full_addero
  (lambda (b x y r c)
  (conde ((== 0 b) (== 0 x) (== 0 y) (== 0 r) (== 0 c))
        ((== 1 b) (== 0 x) (== 0 y) (== 1 r) (== 0 c))
        ((== 0 b) (== 1 x) (== 0 y) (== 1 r) (== 0 c))
        ((== 1 b) (== 1 x) (== 0 y) (== 0 r) (== 1 c))
        ((== 0 b) (== 0 x) (== 1 y) (== 1 r) (== 0 c))
        ((== 1 b) (== 0 x) (== 1 y) (== 0 r) (== 1 c))
        ((== 0 b) (== 1 x) (== 1 y) (== 0 r) (== 1 c))
        ((== 1 b) (== 1 x) (== 1 y) (== 1 r) (== 1 c))
        )
   )); zeroo 260
(define zeroo
                   (lambda (n)
                   (== n '())))
; poso 260
(define poso
             (lambda (n)
             (fresh (h  t ) (== n `(,h . ,t)) )))
; appendo 260
(define appendo
                (lambda (l s out)
                (conde ((== l '())
                      (== s out))
                      ((fresh (a d res)
                         (== `(,a . ,d) l)
                         (== `(,a . ,res) out)
                         (appendo d s res)
                         ))
                      )
                 ))
; gt1o 260
(define gt1o
             (lambda (n)
             (fresh (a  ad  dd ) (== n `(,a ,ad . ,dd)) )))
; addero 260
(define addero
               (lambda (d n m r)
               (conde ((== 0 d) (== m '()) (== n r))
                     ((== 0 d) (== n '()) (== m r) (poso m))
                     ((== 1 d) (== m '()) (inc (addero 0 n one r)))
                     ((== 1 d) (== n '()) (poso m) (inc (addero 0 m one r)))
                     ((== n one) (== m one)
                      (fresh (a c)
                        (== `(,a ,c) r)
                        (full_addero d 1 1 a c)
                        ))
                     ((== n one)
                     (gen_addero d n m r))
                     ((== m one) (gt1o n) (gt1o r) (inc (addero d one n r)))
                     ((gt1o n)
                     (gen_addero d n m r))
                     )
                ))
; gen_addero 260
(define gen_addero
                   (lambda (d n m r)
                   (fresh ( a   b   c   e   x )
                   (fresh (y z)
                     (== `(,a . ,x) n)
                     (== `(,b . ,y) m)
                     (poso y)
                     (== `(,c . ,z) r)
                     (poso z)
                     (full_addero d a b c e)
                     (addero e x y z)
                     ) )))
; pluso 260
(define pluso
              (lambda (n m k)
              (addero 0 n m k)))
; minuso 260
(define minuso
               (lambda (n m k)
               (pluso m k n)))
; bound_multo 260
(define bound_multo
                    (lambda (q p n m)
                    (conde ((== q zero)
                          (poso p))
                          ((fresh ( a0   a1   a2   a3   x )
                           (fresh (y z)
                             (== q `(,a0 . ,x))
                             (== p `(,a1 . ,y))
                             (conde ((== n zero) (== m `(,a2 . ,z))
                                     (bound_multo x y z zero))
                                   ((== n `(,a3 . ,z))
                                   (bound_multo x y z m))
                                   )
                              
                             ) ))
                          )
                     ))
; multo 260
(define multo
              (lambda (n m p)
              (conde ((== n zero)
                    (== p zero))
                    ((poso n) (== m zero) (== p zero))
                    ((== n one) (poso m) (== m p))
                    ((gt1o n) (== m one) (== n p))
                    ((fresh (x z)
                       (== n `(0 . ,x))
                       (poso x)
                       (== p `(0 . ,z))
                       (poso z)
                       (gt1o m)
                       (multo x m z)
                       ))
                    ((fresh (x y)
                       (== n `(1 . ,x))
                       (poso x)
                       (== m `(0 . ,y))
                       (poso y)
                       (multo m n p)
                       ))
                    ((fresh (x y)
                       (== n `(1 . ,x))
                       (poso x)
                       (== m `(1 . ,y))
                       (poso y)
                       (odd_multo x n m p)
                       ))
                    )
               ))
; odd_multo 260
(define odd_multo
                  (lambda (x n m p)
                  (fresh (q)
                    (bound_multo q p n m)
                    (multo x m q)
                    (pluso `(0 . ,q) m p)
                    )))
; eqlo 260
(define eqlo
             (lambda (n m)
             (conde ((== n zero)
                   (== m zero))
                   ((== n one)
                   (== m one))
                   ((fresh (a x b y)
                      (== `(,a . ,x) n)
                      (poso x)
                      (== `(,b . ,y) m)
                      (poso y)
                      (eqlo x y)
                      ))
                   )
              ))
; ltlo 260
(define ltlo
             (lambda (n m)
             (conde ((== n zero)
                   (poso m))
                   ((== n one)
                   (gt1o m))
                   ((fresh (a x b y)
                      (== `(,a . ,x) n)
                      (poso x)
                      (== `(,b . ,y) m)
                      (poso y)
                      (ltlo x y)
                      ))
                   )
              ))
; lelo 260
(define lelo
             (lambda (n m)
             (conde ((eqlo n m))
                   ((ltlo n m))
                   ) ))
; lto 260
(define lto
            (lambda (n m)
            (conde ((ltlo n m))
                  ((eqlo n m)
                  (fresh (x)
                    (poso x)
                    (pluso n x m)
                    ))
                  )
             ))
; leo 260
(define leo
            (lambda (n m)
            (conde ((== n m))
                  ((lto n m))
                  ) ))
; splito 260
(define splito
               (lambda (n r l h)
               (conde ((== n zero) (== h zero) (== l zero))
                     ((fresh (b n_)
                        (== n `(0 ,b . ,n_))
                        (== r zero)
                        (== h `(,b . ,n_))
                        (== l zero)
                        ))
                     ((fresh (n_)
                        (== n `(1 . ,n_))
                        (== r zero)
                        (== n_ h)
                        (== l one)
                        ))
                     ((fresh (b n_ a r_)
                        (== n `(0 ,b . ,n_))
                        (== `(,a . ,r_) r)
                        (== l zero)
                        (splito `(,b . ,n_) r_ zero h)
                        ))
                     ((fresh (n_ a r_)
                        (== n `(1 . ,n_))
                        (== r `(,a . ,r_))
                        (== l one)
                        (splito n_ r_ zero h)
                        ))
                     ((fresh (b n_ a r_ l_)
                        (== n `(,b . ,n_))
                        (== r `(,a . ,r_))
                        (== l `(,b . ,l_))
                        (poso l_)
                        (splito n_ r_ l_ h)
                        ))
                     )
                ))
; divo 260
(define divo
             (lambda (n m q r)
             (conde ((== r n) (== q zero) (lto n m))
                   ((== q one) (eqlo n m) (pluso r m n) (lto r m))
                   ((ltlo m n) (lto r m) (poso q)
                    (fresh ( nh   nl   qh   ql   qlm )
                    (fresh (qlmr rr rh)
                      (splito n r nl nh)
                      (splito q r ql qh)
                      (conde ((== nh zero) (== qh zero) (minuso nl r qlm)
                              (multo ql m qlm))
                            ((poso nh) (multo ql m qlm) (pluso qlm r qlmr)
                             (minuso qlmr nl rr) (splito rr r zero rh)
                             (divo nh m qh rh))
                            )
                       
                      ) ))
                   )
              ))
; repeated_mul 260
(define repeated_mul
                     (lambda (n q nq)
                     (conde ((poso n) (== q zero) (== nq one))
                           ((== q one)
                           (== n nq))
                           ((gt1o q)
                           (fresh (q1 nq1)
                             (pluso q1 one q)
                             (repeated_mul n q1 nq1)
                             (multo nq1 n nq)
                             ))
                           )
                      ))
; exp2 260
(define exp2
             (lambda (n b q)
             (conde ((== n one)
                   (== q zero))
                   ((gt1o n) (== q one) (fresh (s ) (splito n b s one) ))
                   ((fresh (q1 b2)
                      (== q `(0 . ,q1))
                      (poso q1)
                      (ltlo b n)
                      (appendo b `(1 . ,b) b2)
                      (exp2 n b2 q1)
                      ))
                   ((fresh (q1 nh b2 s)
                      (== q `(1 . ,q1))
                      (poso q1)
                      (poso nh)
                      (splito n b s nh)
                      (appendo b `(1 . ,b) b2)
                      (exp2 nh b2 q1)
                      ))
                   )
              ))
; logo 260
(define logo
             (lambda (n b q r)
             (conde ((== n one) (poso b) (== q zero) (== r zero))
                   ((== q zero) (lto n b) (pluso r one n))
                   ((== q one) (gt1o b) (eqlo n b) (pluso r b n))
                   ((== b one) (poso q) (pluso r one n))
                   ((== b zero) (poso q) (== r n))
                   ((== (0 1) b)
                   (fresh (a ad dd)
                     (poso dd)
                     (== n `(,a ,ad . ,dd))
                     (exp2 n '() q)
                     (fresh (s ) (splito n dd r s) )
                     ))
                   ((fresh (a  ad  add  ddd )
                    (conde ((== b three))
                          ((== b `(,a ,ad ,add . ,ddd)))
                          )
                      ) (ltlo b n)
                    (fresh ( bw1   bw   nw   nw1   ql1 )
                    (fresh (ql s)
                      (exp2 b zero bw1)
                      (pluso bw1 one bw)
                      (ltlo q n)
                      (fresh (q1 bwq1)
                        (pluso q one q1)
                        (multo bw q1 bwq1)
                        (lto nw1 bwq1)
                        )
                      (exp2 n zero nw1)
                      (pluso nw1 one nw)
                      (divo nw bw ql1 s)
                      (pluso ql one ql1)
                      (lelo ql q)
                      (fresh (bql qh s2 qdh qd)
                        (repeated_mul b ql bql)
                        (divo nw bw1 qh s2)
                        (pluso ql qdh qh)
                        (pluso ql qd q)
                        (leo qd qdh)
                        (fresh (bqd bq1 bq)
                          (repeated_mul b qd bqd)
                          (multo bql bqd bq)
                          (multo b bq bq1)
                          (pluso bq r n)
                          (lto n bq1)
                          )
                        )
                      ) ))
                   )
              )); expo 260
(define expo
                             (lambda (b q n)
                             (logo n b q zero)))

