class Graph {
   constructor() {
      this.edges = {};
      this.nodes = [];
   }

   addNode(node) {
      this.nodes.push(node);
      this.edges[node] = [];
   }

   addEdge(node1, node2, weight = 1) {
      this.edges[node1].push({ node: node2, weight: weight });
      this.edges[node2].push({ node: node1, weight: weight });
   }

   addDirectedEdge(node1, node2, weight = 1) {
      this.edges[node1].push({ node: node2, weight: weight });
   }

   display() {
      let graph = "";
      this.nodes.forEach(node => {
         graph += node + "->" + this.edges[node].map(n => n.node).join(", ") + "\n";
      });
      console.log(graph);
   }

  
   djikstraAlgorithm(startNode) {
      let distances = {};
      let dis=[];

      // Stores the reference to previous nodes
      let prev = {};
      let pq = new PriorityQueue(this.nodes.length * this.nodes.length);

      // Set distances to all nodes to be infinite except startNode
      distances[startNode] = 0;
      pq.enqueue(startNode);
      dis.push(startNode);

      this.nodes.forEach(node => {
         if (node !== startNode) distances[node] = Infinity;
         prev[node] = null;
      });

      while (!pq.isEmpty()) {
         let minNode = pq.dequeue();
         dis.push(minNode);
         console.log("node",minNode);
         let currNode = minNode.data;
         let weight = minNode.priority;
console.log("edges",this.edges[currNode]);
         this.edges[minNode].forEach(neighbor => {
            console.log("curr",distances[currNode]);
            console.log("neigh",neighbor.weight);
            let alt = distances[minNode] + neighbor.weight;
             console.log("alt",alt);
            if (alt < distances[neighbor.node]) {

               distances[neighbor.node] = alt;
               prev[neighbor.node] = currNode;
               pq.enqueue(neighbor.node);
            }
         });
      }
      console.log("disss",dis);
      console.log("distances",distances);
      return dis;
   }
}

     

const parent = i => ((i + 1) >>> 1) - 1;
const left = i => (i << 1) + 1;
const right = i => (i + 1) << 1;


class PriorityQueue {

  constructor(comparator = (a, b) => a > b) {
    this._heap = [];
    this._comparator = comparator;
  }
  size() {
    return this._heap.length;
  }
  isEmpty() {
    return this.size() == 0;
  }
  peek() {
    return this._heap[top];
  }
  push(...values) {
    values.forEach(value => {
      this._heap.push(value);
      this._siftUp();
    });
    return this.size();
  }
  enqueue(node){
   this._heap.push(node);
  }
  dequeue(){
      if(this.isEmpty()) 
        return "Underflow"; 
    return this._heap.shift(); 
  }
  pop() {
   const top=0;
    const poppedValue = this.peek();
    const bottom = this.size() - 1;
    if (bottom > top) {
      this._swap(top, bottom);
    }
    this._heap.pop();
    this._siftDown();
    return poppedValue;
  }
  replace(value) {
   const top=0;
    const replacedValue = this.peek();
    this._heap[top] = value;
    this._siftDown();
    return replacedValue;
  }
  _greater(i, j) {
    return this._comparator(this._heap[i], this._heap[j]);
  }
  _swap(i, j) {
    [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]];
  }
  _siftUp() {
   const top=0;
    let node = this.size() - 1;
    while (node > top && this._greater(node, parent(node))) {
      this._swap(node, parent(node));
      node = parent(node);
    }
  }
  _siftDown() {
   const top=0;
    let node = top;
    while (
      (left(node) < this.size() && this._greater(left(node), node)) ||
      (right(node) < this.size() && this._greater(right(node), node))
    ) {
      let maxChild = (right(node) < this.size() && this._greater(right(node), left(node))) ? right(node) : left(node);
      this._swap(node, maxChild);
      node = maxChild;
    }
  }
}