interface Handler {

    Handler setNext(Handler next);
    Handler getNext();
    void handleRequest(String requestPath, Object req);
}

class StoreApiHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public void handleRequest(String requestPath, Object req) {
        if (requestPath.startsWith(Constants.STORE_API_PREFIX)) {
            //  do something with req body
            System.out.println("[StoreApiHandler::\tHandle request...]");
        } else if (next != null) {
            next.handleRequest(requestPath, req);
        }
    }
}

class KitchenApiHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public void handleRequest(String requestPath, Object req) {
        if (requestPath.startsWith(Constants.KITCHEN_API_PREFIX)) {
            //  do something with req body
            System.out.println("[KitchenApiHandler::\tHandle request...]");
        } else if (next != null) {
            next.handleRequest(requestPath, req);
        }
    }
}

class DeliveryApiHandler implements Handler {
    private Handler next = null;


    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public void handleRequest(String requestPath, Object req) {
        if (requestPath.startsWith(Constants.DELIVERY_API_PREFIX)) {
            //  do something with req body
            System.out.println("[DeliveryApiHandler::\tHandle request...]");
        } else if (next != null) {
            next.handleRequest(requestPath, req);
        }
    }
}
