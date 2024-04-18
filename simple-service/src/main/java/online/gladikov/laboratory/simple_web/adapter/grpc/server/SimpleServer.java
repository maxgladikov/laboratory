//package online.gladikov.laboratory.simple_web.adapter.grpc.server;
//
//import io.grpc.stub.StreamObserver;
//
//@GrpcS
//public class SimpleServer {
//
//    @Override
//    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
////        String name = request.getName();
//        String greeting = "Hello!!!";
//
//        GreetResponse response = GreetResponse.newBuilder()
//            .setGreeting(greeting)
//            .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}
