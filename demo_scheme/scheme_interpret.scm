
;;; There are 4 relations
; lookupo2 260
(define lookupo2
                                            (lambda (x env t)
                                            (fresh (rest y v)
                                              (== `((,y ,v) . ,rest) env)
                                              (conde ((== y x)
                                                    (== v t))
                                                    ((=/= y x)
                                                    (lookupo2 x rest t))
                                                    )
                                               
                                              )))
; not_in_envo2 260
(define not_in_envo2
                     (lambda (x env)
                     (conde ((fresh (y v rest)
                               (== env `((,y ,v) . ,rest))
                               (=/= y x)
                               (not_in_envo2 x rest)
                               ))
                           ((== '() env))
                           )
                      ))
; proper_listo2 260
(define proper_listo2
                      (lambda (es env rs)
                      (conde ((== '() es)
                            (== '() rs))
                            ((fresh (e d te td)
                               (== es `(,e . ,d))
                               (== rs `(,te . ,td))
                               (evalo2 e env `(val ,te))
                               (proper_listo2 d env td)
                               ))
                            )
                       ))
; evalo2 260
(define evalo2
               (lambda (term env r)
               (conde ((fresh (t)
                         (== term `(seq ((symb 'quote) ,t)))
                         (== r `(val ,t))
                         (not_in_envo2 'quote env)
                         ))
                     ((fresh (es rs)
                        (== term `(seq ((symb 'list) . ,es)))
                        (== r `(val (seq ,rs)))
                        (not_in_envo2 'list env)
                        (proper_listo2 es env rs)
                        ))
                     ((fresh (s)
                        (== term `(symb ,s))
                        (lookupo2 s env r)
                        ))
                     ((fresh ( func   arge   arg   x   body )
                      (fresh (env2)
                        (== term `(seq (,func ,arge)))
                        (evalo2 arge env arg)
                        (evalo2 func env `(closure (,x ,body ,env2)))
                        (evalo2 body `((,x ,arg) . ,env2) r)
                        ) ))
                     ((fresh (x body)
                        (== term `(seq ((symb 'lambda) (seq ((symb ,x))) ,body)))
                        (not_in_envo2 'lambda env)
                        (== r `(closure (,x ,body ,env)))
                        ))
                     )
                ))

