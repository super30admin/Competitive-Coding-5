function countArrangement(n: number): number {
  if (n == 1) {
    return 1;
  }
  let count: number = 0;

  let permutation: number[][] = [];

  function backtrack(path: number[]) {
    if (path.length == n) {
      permutation.push([...path]);
      count++;
      return;
    }

    for (let index = 1; index <= n; index++) {
      if (path.includes(index)) continue;

      let permutation = index;
      let i = path.length + 1;
      if (permutation % i == 0 || i % permutation == 0) {
        path.push(index);
        backtrack(path);
        path.pop();
      }
    }
  }
  backtrack([]);
  return count;
}

describe("Beautiful Arrangement", () => {
  it("Happy Path - 01", () => {
    expect(countArrangement(2)).toEqual(2);
  });
  it("Happy Path - Complex 01", () => {
    expect(countArrangement(3)).toEqual(3);
  });
  it("Happy Path - Complex 02", () => {
    expect(countArrangement(11)).toEqual(750);
  });
});
