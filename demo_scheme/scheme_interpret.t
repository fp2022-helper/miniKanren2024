  $ ls
  default_quines.scm
  scheme_interpret.scm
  test_interpret.scm
$ cat OlegNumbers.scm
  $ scheme --script ./test_interpret.scm
  Smoke test for default quines with absento
  (((''((lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0)))))) '((lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0)))))) ((lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list _.0 (list 'quote _.0))))))) (=/= ((_.0 closure)) ((_.0 list)) ((_.0 quote))) (sym _.0)) ((''((lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0)))))) '((lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0)))))) ((lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0))))) '(lambda (_.0) (list 'quote (list 'quote (list ((lambda (_.1) _.0) '_.2) (list 'quote _.0))))))) (=/= ((_.0 _.1)) ((_.0 closure)) ((_.0 lambda)) ((_.0 list)) ((_.0 quote)) ((_.1 closure))) (sym _.0 _.1) (absento (closure _.2))))
  Smoke testing of synthesized interpreter
  ((((seq ((seq ((symb 'lambda) (seq ((symb _.0))) (seq ((symb 'list) (symb _.0) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.0))))))) (seq ((symb 'quote) (seq ((symb 'lambda) (seq ((symb _.0))) (seq ((symb 'list) (symb _.0) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.0))))))))))) (seq ((seq ((symb 'lambda) (seq ((symb _.1))) (seq ((symb 'list) (symb _.1) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.1))))))) (seq ((symb 'quote) (seq ((symb 'lambda) (seq ((symb _.1))) (seq ((symb 'list) (symb _.1) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.1)))))))))))) (=/= ((_.1 list)) ((_.1 quote)))))
  Looking for first quine (((seq ((seq ((symb 'lambda) (seq ((symb _.0))) (seq ((symb 'list) (symb _.0) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.0))))))) (seq ((symb 'quote) (seq ((symb 'lambda) (seq ((symb _.0))) (seq ((symb 'list) (symb _.0) (seq ((symb 'list) (seq ((symb 'quote) (symb 'quote))) (symb _.0))))))))))) (=/= ((_.0 list)) ((_.0 quote)))))
