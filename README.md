## 프로젝트 설명
회사에서 자체 개발한 프레임워크로 Graphql API를 개발하고 있는데, 자체 개발한 프레임워크여서 그런지 여러 시행착오를 겪고 있다.
만약 많은 사람들의 고민을 거쳐 탄생한 프레임워크를 사용한다면 시행착오를 줄이고 비즈니스 구현에 집중할 수 있게되어 조직의 생산성 향상에도 기여할 수 있지 않을까해서 이 프레임워크의 도입 여부를 확인하기 위해 프로젝트를 시작하였다.
추가로 Java, Spring 기반의 GraphQL API 개발 관련 인사이트를 얻을 수 있을 것이라 기대하고 있다.

## TODO
- [x]간단 Album CRUD resolver 구현 (Query, Mutation resolver)
- [ ] input, instance validation 구현
  - input validation은 custom directive 및 SchemaDirectiveWiring 인터페이스의 구현 클래스 구현
  - instance validation은 서비스 계층에 구현