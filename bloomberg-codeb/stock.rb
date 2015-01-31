# stock.rb
require 'sinatra'

get '/' do
  erb :index
end
get '/orders' do
  res = ""
  File.open("test.txt") do |f|
    f.each_line do |line|
      res += line
    end
  end
  erb :buysell, :locals => {:res => parse(res)}
end

get '/market' do
  marketData = ""
  File.open("ticker.txt") do |f|
    f.each_line do |line|
      marketData += line
    end
  end
  erb :market, :locals => {:marketData => parseTicker(marketData)}
end

helpers do
  def parse(res)
    parseArr = res.split(" ")
    bidaskArr = []
    i = 0
    id = 0
    while i < parseArr.length do
      if parseArr[i] == "BUY" || parseArr[i] == "SELL"
        temp = BidAsk.new(id, parseArr[i], parseArr[i+1], parseArr[i+2], parseArr[i+3], parseArr[i+4])
        bidaskArr.push(temp)
        i += 5
        id += 1
      else
        i += 3
      end
    end

    return bidaskArr
  end

  def parseTicker(data)
    parse = data.split(" ")
    tick = []
    i = 0
  end

end

class Market
  def initialize(id, stock, worth, bid, ask)
    @id = id
    @stock = stock
    @worth = worth
    @bid = bid
    @ask = ask
  end

class BidAsk
  def initialize(id, type, stock, price, shares, cash)
    @id = id
    @type = type
    @stock = stock
    @price = price
    @shares = shares
    @cash = cash
  end

  def getId()
    return @id
  end
  def getType()
    return @type
  end
  
  def getStock()
    return @stock
  end
  
  def getPrice()
    return @price
  end

  def getShares()
    return @shares
  end

  def getCash()
    return @cash
  end
end
