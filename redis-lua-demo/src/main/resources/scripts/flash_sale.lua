local member = ARGV[1]

-- Check if the entry already exists in sorted set
if redis.call('ZSCORE', KEYS[2], member) then
    return -1 -- ERROR: Already exists
end

local current = redis.call('GET', KEYS[1])
if current and tonumber(current) >= tonumber(KEYS[3]) then
    -- Decrement counter
    local counter = redis.call('DECRBY', KEYS[1], KEYS[3])
    local score = redis.call('TIME')
    -- Add to sorted set
    redis.call('ZADD', KEYS[2], score[1] * 1000000 + score[2], member)
    return counter
else
    return -2 -- ERROR: Insufficient counter
end


