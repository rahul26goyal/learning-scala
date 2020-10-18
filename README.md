# learning-scala
A Repo containing DS and Algorithms. solved using Scala Programming Language

# Prevent committing secrets:
Using https://github.com/awslabs/git-secrets for this:
- `brew install git-secrets` => install plugin
- `git secrets --install` => set pre-commit check for current repo.
- `git secrets --register-aws` => adds common aws pattern.
- `git secrets --scan-history` => scans previous commits too.
- `git secrets --scan <file>` => adhoc scan.

