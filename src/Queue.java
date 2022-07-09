public class Queue {
    //int [] Queue = new int [Main.fileobj.fileSize()];
    int front, rear, sizeOfArray, i;

    Node queue[], temp;
    int tempFreq[];

    Queue()
    {
        front = rear = 0;
        sizeOfArray = Main.fileobj.fileSize("sample.txt");
        queue = new Node[sizeOfArray];
        tempFreq = new int[sizeOfArray];
    }

//........................................................................................................ ENQUEUE
    void enqueue()
    {
        char array[] = Main.fileobj.getData();
        int freq[] = Main.fileobj.getFreq();

        for (int i = 0; i < Main.fileobj.getData().length; i++)
        {
            if (array[i] != '0')
            {
                Node newNode = new Node(array[i], freq[i]);
                addToQueue(newNode);
            }
        }
    }

    void addToQueue(Node newNode)
    {
        if (sizeOfArray == rear)
        {
            System.out.println("full");
            return;
        } else
        {
            queue[rear] = newNode;
            rear++;
            bubbleSort();
        }
        return;
    }

//........................................................................................................... DEQUEUE

    Node deQueue()
    {
        if(front == rear)
        {
            System.out.println("empty queue");
        }
        else
        {
            temp = queue[0];
            for(int i =0; i<rear-1; i++)
            {
                queue[i] = queue[i+1];
            }
            rear--;
        }
        return temp;
    }

    Node [] getQueue()
    {
        return queue;
    }

//....................................................................................................... DISPLAY QUEUE
    void queueDisplay()
    {
        for (int i = 0; i < rear; i++)
        {
            System.out.print(queue[i].data + "-");
        }

    }

    Boolean isEmpty()
    {
     return rear==1;
    }



    Node front() {
        if (front == rear) {
            System.out.println("full");
            return null;
        }
        return queue[front];
    }

//......................................................................................................... SORT
    void bubbleSort()
    {
        int n = rear;
        Node temp = null;
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < (n - i); j++)
            {
                if (queue[j - 1].freq > queue[j].freq)
                {
                    //swap elements
                    temp = queue[j - 1];
                    queue[j - 1] = queue[j];
                    queue[j] = temp;
                }

            }
        }
    }


}
//min priority queue