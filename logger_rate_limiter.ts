class Logger {
  map: Map<string, number> = new Map();

  constructor() {
    this.map = new Map();
  }

  shouldPrintMessage(timestamp: number, message: string): boolean {
    if (!this.map.has(message)) {
      this.map.set(message, timestamp);
      return true;
    } else {
      let previous_timestamp: number = this.map.get(message)!;
      let diff = timestamp - previous_timestamp;
      if (diff >= 10) {
        this.map.set(message, timestamp);
        return true;
      }
    }
    return false;
  }
}

describe("Logger Rate Limiter", () => {
  it("Happy Path - 01", () => {
    let logger = new Logger();
    expect(logger.shouldPrintMessage(1, "foo")).toEqual(true);
    expect(logger.shouldPrintMessage(2, "bar")).toEqual(true);
    expect(logger.shouldPrintMessage(3, "foo")).toEqual(false);
    expect(logger.shouldPrintMessage(8, "bar")).toEqual(false);
    expect(logger.shouldPrintMessage(10, "foo")).toEqual(false);
    expect(logger.shouldPrintMessage(11, "foo")).toEqual(true);
  });
});
